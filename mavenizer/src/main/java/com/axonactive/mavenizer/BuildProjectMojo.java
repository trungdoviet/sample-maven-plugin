package com.axonactive.mavenizer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo( name = "build-mavenizer", defaultPhase = LifecyclePhase.PACKAGE )
public class BuildProjectMojo extends AbstractMojo{

	@Parameter( defaultValue = "${project.build.directory}", property = "outputDir", required = true )
    private File outputDirectory;
	
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("Build file on: "+outputDirectory.getAbsolutePath());
		 File f = outputDirectory;

	        if ( !f.exists() )
	        {
	            f.mkdirs();
	        }

	        File touch = new File( f, "build.txt" );

	        FileWriter w = null;
	        try
	        {
	            w = new FileWriter( touch );
	            w.write( "Build has just completed on " + new Date() );
	        }
	        catch ( IOException e )
	        {
	            throw new MojoExecutionException( "Error creating file " + touch, e );
	        }
	        finally
	        {
	            if ( w != null )
	            {
	                try
	                {
	                    w.close();
	                }
	                catch ( IOException e )
	                {
	                    // ignore
	                }
	            }
	        }

	}

}
