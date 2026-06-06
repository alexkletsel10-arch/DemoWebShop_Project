package utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider(name = "DemoWebCsv")
    public Iterator<Object[]> DemoWebCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/DemoWebRegistrationValidValues.csv"))
        );

        String line = reader.readLine();
        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{split[0],split[1],split[2],split[3],split[4]}); // email, password

            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }

    @DataProvider(name = "LoginCsv")
    public Iterator<Object[]> loginCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/loginPageCsv.csv"))
        );

        String line = reader.readLine();
        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{split[0],split[1]}); // email, password

            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
    @DataProvider(name = "loginCsvInvalidValues")
    public Iterator<Object[]> loginCsvInvalidValues() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/loginPageCsvInvalidPasswordValues.csv"))
        );

        String line = reader.readLine();
        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{split[0],split[1]}); // email, password

            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
    @DataProvider(name = "loginPageCsvEmptyPasswordField")
    public Iterator<Object[]>loginPageCsvEmptyPasswordField() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/loginPageCsvEmptyPasswordField.csv"))
        );

        String line = reader.readLine();
        while (line != null) {

            String[] split = line.split(",", -1);

            list.add(new Object[]{split[0],split[1]}); // email, password

            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
    @DataProvider(name = "loginPageCsvInvalidEmailField")
    public Iterator<Object[]>loginPageCsvInvalidEmailField() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/loginPageCsvInvalidEmailField.csv"))
        );

        String line = reader.readLine();
        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{split[0],split[1]}); // email, password

            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
    @DataProvider(name = "loginPageCsvEmptyEmailField")
    public Iterator<Object[]>loginPageCsvEmptyEmailField() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/loginPageCsvEmptyEmailField.csv"))
        );

        String line = reader.readLine();
        while (line != null) {

            String[] split = line.split(",", -1);

            list.add(new Object[]{split[0],split[1]}); // email, password

            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
    @DataProvider(name = "regInvalidEmailValues")
    public Iterator<Object[]>registrationInvalidEmailFieldValues() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/registrationInvalidEmailFieldValues.csv"))
        );

        String line = reader.readLine();
        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{split[0],split[1],split[2],split[3],split[4]}); // email, password

            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
    @DataProvider(name = "regInvalidPasswordValues")
    public Iterator<Object[]>regInvalidPasswordValues() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/registrationInvalidPasswordFieldValues.csv"))
        );

        String line = reader.readLine();
        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{split[0],split[1],split[2],split[3],split[4]}); // email, password

            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
    @DataProvider(name = "regEmptyEmailField")
    public Iterator<Object[]>regEmptyEmailField() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/regEmptyEmailField.csv"))
        );

        String line = reader.readLine();
        while (line != null) {

            String[] split = line.split(",",-1);

            list.add(new Object[]{split[0],split[1],split[2],split[3],split[4]}); // email, password

            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
    @DataProvider(name = "regEmptyPasswordField")
    public Iterator<Object[]>regEmptyPasswordField() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/regEmptyPasswordField.csv"))
        );

        String line = reader.readLine();
        while (line != null) {

            String[] split = line.split(",",-1);

            list.add(new Object[]{split[0],split[1],split[2],split[3],split[4]}); // email, password

            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }




}


