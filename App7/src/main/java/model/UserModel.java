package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import business.User;

public class UserModel {
	public static void store(User user, String filepath) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(filepath, true));
		out.println(user.getName()+" | " + user.getEmail() + " | " + user.getMobile());
		out.close();
	}
}
