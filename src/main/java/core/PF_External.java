package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PF_External {

	Properties p = new Properties();

	String getPropertyOut(String prop_file, String property) throws IOException {
		p.load(new FileInputStream(prop_file));
		return p.getProperty(property);
	}

	public static void main(String[] args) throws IOException {

		if (args.length == 0) {
			System.err.println("Please enter a path as an argument");
			System.exit(1);
		}
		if (!args[0].contains(".properties")) {
			System.err.println("Argument must be an properties file");
			System.exit(1);
		}
		String pf_out = args[0]; // String pf_out =
									// "./src/main/resources/in.properties";
		PF_External p = new PF_External();

		System.out.println("Title: \t\t\t\t" + p.getPropertyOut(pf_out, "title"));
		System.out.println("First Name: \t\t\t" + p.getPropertyOut(pf_out, "first_name"));
		System.out.println("Last Name: \t\t\t" + p.getPropertyOut(pf_out, "last_name"));
		System.out.println("Current directory: \t\t" + System.getProperty("user.dir"));
		System.out.println("Properties file location: \t" + new java.io.File(pf_out).getCanonicalPath());
	}
}
