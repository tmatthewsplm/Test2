package uitest.framework;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import uitest.config.TestConfig;
import uitest.util.CompressUtil;
import uitest.util.DirectoryUtil;
import uitest.util.PropertiesUtil;
import uitest.util.ScreenShotReportUtil;
import java.io.*;

/**
 * Base class for all tests.  Provides spring support for TestNG, SLF4J logging, and target property support.
 */
@ContextConfiguration(classes = {
	TestConfig.class,
})
@TestPropertySource(locations = {"classpath:env-${env:default}.properties"})
abstract public class AbstractTest extends AbstractTestNGSpringContextTests {

	/* TODO
	 * need to separate the selenium test and rest test report
	 */
	protected final String SCREEN_SHOT_FOLDER = "target/surefire-reports/screenshots"; //it is better to hard coding it as same as other surefire report
	protected final String ZIP_FILE_PATH = "target/surefire-reports/screenShotReport.zip"; //it is better to hard coding it as same as other surefire report
	//shell script paths
	protected final String LOGIN_DEV_HUB = "User/theo/git/test/scripts/login_dev_hub.sh";
	protected final String SETUP_SCRATCH_ORG = "User/theo/git/test/scripts/setup_scratch_org.sh";
	protected final String DELETE_SCRATCH_ORG = "User/theo/git/test/scripts/delete_scratch_org.sh";
	protected static String scratchOrgAlias = "";
	protected static String scratchURL ="";

	// Not static: we want log information included from each of the subclasses, not from this one.
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected Environment env;

	@BeforeSuite(alwaysRun = true)
	protected void cleanFolder(){
		//remove the screenshot report folder
		log.info("** \n\n ** Begin Test Suite \n");
		DirectoryUtil.deleteDir(new File(SCREEN_SHOT_FOLDER));
	}
	// @BeforeSuite(alwaysRun = true)
	// protected void spinUpScratchOrg(){
	// 	//create dev hub
	// 	try{
	// 		String line = null;
	// 		scratchOrgAlias = genAlias();
	// 		System.out.println(scratchOrgAlias);
	// 		ProcessBuilder pb = new ProcessBuilder("/Users/theo/git/ui_test_automation_fw/uitest/src/test/scripts/setup_scratch_org.sh" , scratchOrgAlias);
	// 		pb.redirectErrorStream(true);
	// 		Process process = pb.start();
	// 		InputStream is = process.getInputStream();
	// 		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	// 		while ((line = reader.readLine()) != null) {
	// 			System.out.println(line);
	// 		}
	// 		pb = new ProcessBuilder("/Users/theo/git/ui_test_automation_fw/uitest/src/test/scripts/get_scratch_org_json_details.sh", scratchOrgAlias);
	// 		pb.redirectErrorStream(true);
	// 		process = pb.start();
	// 		is = process.getInputStream();
	// 		reader = new BufferedReader(new InputStreamReader(is));
	// 		while ((line = reader.readLine()) != null) {
	// 			System.out.println(line);
	// 			String[] jsonStrings=line.split("URL:");;
	// 			System.out.println(jsonStrings[1]);
	// 			scratchURL = jsonStrings[1];
	// 		}
	// 	} catch (Exception e){
	// 		log.error(e.toString());
	// 	}
	// }
  //
	// private static String genAlias(){
	// 	int min = 0000000;
	// 	int max = 9999999;
	// 	Random rand = new Random();
	// 	int i = rand.nextInt(max) + min;
	// 	return String.valueOf(i);
	// }
	// @AfterSuite(alwaysRun=true)
	// protected void deleteScratchOrg(){
	// 	try{
	// 	String line = "";
	// 	ProcessBuilder pb = new ProcessBuilder("/Users/theo/git/ui_test_automation_fw/uitest/src/test/scripts/delete_scratch_org.sh", scratchOrgAlias);
	// 	pb.redirectErrorStream(true);
	// 	Process process = pb.start();
	// 	InputStream is = process.getInputStream();
	// 	BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	// 	while ((line = reader.readLine()) != null) {
  //           System.out.println(line);
	// 	}
	// 	}catch (Exception e){
	// 		System.out.println(e.toString());
	// 	}
	// }
	@AfterSuite(alwaysRun = true)
	protected void outPutReport(){
		log.info("\n\n ** All the tests completed!");
		if (env != null && PropertiesUtil.getScreenshotStatus(env)) {
			// generate screenshot report
			ScreenShotReportUtil.generateReport(SCREEN_SHOT_FOLDER);
			// compress the report folder
			CompressUtil.zipCompress(SCREEN_SHOT_FOLDER, ZIP_FILE_PATH);
		} else if (System.getProperty("env") != null && !System.getProperty("env").trim().equals("")) {
			log.info("the test env is empty, move the system property");
			try {
				Properties prop = new Properties();
				prop.load(getClass().getClassLoader().getResourceAsStream("env-"+System.getProperty("env")+".properties"));
				if(PropertiesUtil.getScreenshotStatus(prop)){
					// generate screenshot report
					ScreenShotReportUtil.generateReport(SCREEN_SHOT_FOLDER);
					// compress the report folder
					CompressUtil.zipCompress(SCREEN_SHOT_FOLDER, ZIP_FILE_PATH);
				}
			} catch (IOException e) {
				log.error("Error", e);
			}
		} else {
			log.error("Error, the env parameter is null.");
		}
	}
}
