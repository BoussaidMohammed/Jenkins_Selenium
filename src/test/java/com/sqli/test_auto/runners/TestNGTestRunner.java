package com.sqli.test_auto.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import static com.sqli.test_auto.utilities.Utilities.*;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    public static final String reportOutputDirectory = getConfigProperty("cucumber.reportOutputDirectory");
    public static final String projectName = getConfigProperty("project.name");

    @AfterSuite
    @Override
    public void tearDownClass() {
        super.tearDownClass();
        generateCucumberReport(reportOutputDirectory);
    }

    private void generateCucumberReport(String reportDirLocation) {
        //To generate cucumber reports, we have to get to setup up a ReportBuilder with the JSON generated files.
        //The JSON generated files are within the result directory (result.getReporterDir()).
        File reportDir = new File(reportDirLocation);
        //filtering only json files.
        Collection<File> jsonCollection = FileUtils.listFiles(reportDir, new String[]{"json"}, true);
        List<String> jsonFiles = new ArrayList<>();//it will contain absolute path to JSON files.
        jsonCollection.forEach(file -> jsonFiles.add(file.getAbsolutePath()));
        Configuration configuration = new Configuration(reportDir, projectName);
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}

