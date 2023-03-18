/*
Name: Visho Malla Oli
Current Date: 18 March 2023
Sources Consulted: None

By submitting this work, I attest that it is my original work and that I did
not violate the University of Mississippi academic policies set forth in the M book.
*/

import java.io.FileNotFoundException;

public class DriverP3 {
    // main method
    public static void main(String[] args) throws FileNotFoundException {
        /**
         * Welcome Message
         */
        System.out.println("                                                                                                                                          \n" +
                ",--------.,--.  ,--.                      ,-----.                                           ,--.                ,--.  ,--.                \n" +
                "'--.  .--'`--',-'  '-.,--,--.,--,--,     '  .--./ ,---. ,--,--,--.,--,--,--.,--.,--.,--,--, `--' ,---. ,--,--.,-'  '-.`--' ,---. ,--,--,  \n" +
                "   |  |   ,--.'-.  .-' ,-.  ||      \\    |  |    | .-. ||        ||        ||  ||  ||      \\,--.| .--'' ,-.  |'-.  .-',--.| .-. ||      \\ \n" +
                "   |  |   |  |  |  | \\ '-'  ||  ||  |    '  '--'\\' '-' '|  |  |  ||  |  |  |'  ''  '|  ||  ||  |\\ `--.\\ '-'  |  |  |  |  |' '-' '|  ||  | \n" +
                "   `--'   `--'  `--'  `--`--'`--''--'     `-----' `---' `--`--`--'`--`--`--' `----' `--''--'`--' `---' `--`--'  `--'  `--' `---' `--''--' \n" +
                "                                                                                                                                          ");

        /**
         * Objects
         */
        Business currentBusiness = new Business("Titan Communication");

        /**
         * Calling Methods
         */
        // reads and stores file from directory
        currentBusiness.filesReader("src/main/TitanCommunication.txt");

        // outputs information stored
        currentBusiness.businessInformation();

        // modification to the current data
        currentBusiness.changesInBusiness();


    }
}
