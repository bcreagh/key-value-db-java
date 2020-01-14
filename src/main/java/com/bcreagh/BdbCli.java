package com.bcreagh;

import com.bcreagh.request.Request;
import com.bcreagh.request.RequestDispatcher;
import com.bcreagh.request.RequestFactory;

import java.util.Scanner;

/**
 * Provides a CLI for the database.
 */
public class BdbCli
{

    private static Scanner scanner;

    public static void main( String[] args )
    {
        scanner = new Scanner(System.in);
        RequestFactory requestFactory = new RequestFactory();
        RequestDispatcher requestDispatcher = BdbInitializer.initialize();

        String[] input = getNextLine();

        while (!(input.length > 0 && input[0].equals("exit"))) {

            if (input.length == 0) {
                continue;
            }

            Request request = requestFactory.createRequest(input);
            requestDispatcher.dispatch(request);

            input = getNextLine();
        }
    }

    private static String[] getNextLine() {
        return scanner.nextLine().split("\\s+");
    }
}
