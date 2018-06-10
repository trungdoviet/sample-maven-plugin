package com.axonactive.mavenizer;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo( name = "log-mavenizer", defaultPhase = LifecyclePhase.PROCESS_SOURCES )
public class LoggingMojo extends AbstractMojo{

	@Parameter( defaultValue = "${project.build.directory}", property = "outputDir", required = true )
    private File outputDirectory;
	@Parameter(defaultValue="I'm mavenizer", property="message")
	private String message;
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info(message);
	}

}
