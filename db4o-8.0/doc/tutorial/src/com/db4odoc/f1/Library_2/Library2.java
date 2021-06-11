package com.db4odoc.f1.Library_2;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Predicate;
import com.db4o.query.Query;
import com.db4odoc.f1.Library_2.modules.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.db4odoc.f1.Util.listResult;

public class Library2 {

    final static String DB4OFILENAME = System.getProperty("user.home") + "/library.db4o";

    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded
                .newConfiguration(), DB4OFILENAME);
        try {
            storeSubjects(db);
            retrieveAllPersonsFromSubjects(db);
            retrieveAllOrganizationsFomSubject(db);
            retrieveAllSubjects(db);

            storeItems(db);
            retrieveAllMonographFromItems(db);
            retrieveAllBooksFromItems(db);
            retrieveAllReportsFromItems(db);
            retrieveAllAMFromItems(db);
            retrieveAllThesisFromItems(db);
            retrieveAllDissertationFromItems(db);
            retrieveAllThesisFromAM(db);
            retrieveAllDissertationFromAM(db);
            retrieveAllSerialItems(db);
            retrieveAllItems(db);

            retrieveAllAccounts(db);
            retrieveAllAccountsByNegation(db);

            updateCopiesBook1(db);
            updateAccountPerson3ToInvalid(db);

            borrowItems(db);

            retrieveByConjunction(db);
            retrieveByDisjunction(db);
            retrieveByComparison(db);
            retrieveByDefaultFieldValue(db);
            retrieveSorted(db);

            clearDatabase(db);
        } finally {
            db.close();
        }
    }


    // SUBJECTS

    static void storeSubjects(ObjectContainer db) {

        // Organization

        Subject organization1 = new Organization("organization1", null);
        Subject organization2 = new Organization("organization2", null);
        Subject organization3 = new Organization("organization3", null);

        db.store(organization1);
        db.store(organization2);
        db.store(organization3);

        // Persons

        Subject person1 = new Person("person1", null);
        Subject person2 = new Person("person2", null);
        Subject person3 = new Person("person3", null);

        // Accounts

        Account accountPerson1 = new Account(new Date(2021, Calendar.FEBRUARY, 5), true, "sometype", new ArrayList<Borrow>(), (Person) person1);
        Account accountPerson2 = new Account(new Date(2021, Calendar.MARCH, 12), false, "sometype", new ArrayList<Borrow>(), (Person) person2);
        Account accountPerson3 = new Account(new Date(2021, Calendar.MARCH, 1), true, "sometype", new ArrayList<Borrow>(), (Person) person3);

        db.store(accountPerson1);
        db.store(accountPerson2);
        db.store(accountPerson3);

        ((Person) person1).setAccount(accountPerson1);
        ((Person) person2).setAccount(accountPerson2);
        ((Person) person3).setAccount(accountPerson3);
        db.store(person1);
        db.store(person2);
        db.store(person3);
    }

    static void retrieveAllPersonsFromSubjects(ObjectContainer db) {

        Query query = db.query();
        query.constrain(Subject.class);
        query.descend("name").constrain(Person.class);
        ObjectSet result = query.execute();
        listResult(result);
    }

    static void retrieveAllOrganizationsFomSubject(ObjectContainer db) {

        Query query = db.query();
        query.constrain(Subject.class);
        query.descend("name").constrain(Organization.class);
        ObjectSet result = query.execute();
        listResult(result);
    }

    static void retrieveAllSubjects(ObjectContainer db) {

        Query query = db.query();
        query.constrain(Subject.class);
        query.descend("name").orderAscending();
        ObjectSet result = query.execute();
        listResult(result);
    }


    // ITEMS

    static void storeItems(ObjectContainer db) {

        // BOOKS

        Monograph book1 = new Book(new ArrayList<Copy>(), getSubject(db, "person3"), 20, "Book1");
        Monograph book2 = new Book(new ArrayList<Copy>(), getSubject(db, "person1"), 60, "Book2");

        Item itemBook1 = book1;
        Item itemBook2 = book2;

        db.store(itemBook1);
        db.store(itemBook2);

        // REPORTS

        Monograph report1 = new Report(new ArrayList<Copy>(), getSubject(db, "person2"), 5);
        Monograph report2 = new Report(new ArrayList<Copy>(), getSubject(db, "person3"), 120);

        Item itemReport1 = report1;
        Item itemReport2 = report2;

        db.store(itemReport1);
        db.store(itemReport2);

        // THESIS

        AcademicMonograph thesis1 = new Thesis(new ArrayList<Copy>(), getSubject(db, "person1"), 80);
        AcademicMonograph thesis2 = new Thesis(new ArrayList<Copy>(), getSubject(db, "person3"), 100);

        Monograph monographThesis1 = thesis1;
        Monograph monographThesis2 = thesis2;

        Item itemThesis1 = monographThesis1;
        Item itemThesis2 = monographThesis2;

        db.store(itemThesis1);
        db.store(itemThesis2);

        // DISSERTATION

        AcademicMonograph dissertation1 = new Dissertation(new ArrayList<Copy>(), getSubject(db, "person1"), 70);
        AcademicMonograph dissertation2 = new Dissertation(new ArrayList<Copy>(), getSubject(db, "person2"), 50);

        Monograph monographDissertation1 = dissertation1;
        Monograph monographDissertation2 = dissertation2;

        Item itemDissertation1 = monographDissertation1;
        Item itemDissertation2 = monographDissertation2;

        db.store(itemDissertation1);
        db.store(itemDissertation2);

        // Serial Item

        SerialItem serialItem1 = new Serial(new ArrayList<Copy>(), 22, "I", new Date(2021, 3, 9), "serial1", (Person) getSubject(db, "person2"), (Organization) getSubject(db, "organization1"));
        SerialItem serialItem2 = new Serial(new ArrayList<Copy>(), 2, "IV", new Date(2021, 12, 3), "serial2", (Person) getSubject(db, "person3"), (Organization) getSubject(db, "organization3"));

        Item itemSerialItem1 = serialItem1;
        Item itemSerialItem2 = serialItem2;

        db.store(itemSerialItem1);
        db.store(itemSerialItem2);
    }

    static void retrieveAllMonographFromItems(ObjectContainer db) {
        System.out.println("\n------\nRetrieve all Monographs\n");
        Query query = db.query();
        query.constrain(Item.class);
        query.descend("pages").constrain(Monograph.class);
        ObjectSet result = query.execute();
        listResult(result);
    }

    static void retrieveAllBooksFromItems(ObjectContainer db) {

        System.out.println("\n------\nRetrieve all Books\n");

        Query query = db.query();
        query.constrain(Item.class);
        query.descend("pages").constrain(Book.class);
        ObjectSet result = query.execute();
        listResult(result);
    }

    static void retrieveAllReportsFromItems(ObjectContainer db) {

        System.out.println("\n------\nRetrieve all Reports\n");

        Query query = db.query();
        query.constrain(Item.class);
        query.descend("pages").constrain(Report.class);
        ObjectSet result = query.execute();
        listResult(result);
    }

    static void retrieveAllAMFromItems(ObjectContainer db) {

        System.out.println("\n------\nRetrieve all Academic monographs\n");

        Query query = db.query();
        query.constrain(Item.class);
        query.descend("pages").constrain(AcademicMonograph.class);
        ObjectSet result = query.execute();
        listResult(result);
    }

    static void retrieveAllThesisFromItems(ObjectContainer db) {

        System.out.println("\n------\nRetrieve all Thesis\n");

        Query query = db.query();
        query.constrain(Item.class);
        query.descend("pages").constrain(Thesis.class);
        ObjectSet result = query.execute();
        listResult(result);
    }

    static void retrieveAllDissertationFromItems(ObjectContainer db) {

        System.out.println("\n------\nRetrieve all Dissertations\n");

        Query query = db.query();
        query.constrain(Item.class);
        query.descend("pages").constrain(Dissertation.class);
        ObjectSet result = query.execute();
        listResult(result);
    }

    static void retrieveAllThesisFromAM(ObjectContainer db) {

        System.out.println("\n------\nRetrieve all Thesis from Monographs\n");

        Query query = db.query();
        query.constrain(AcademicMonograph.class);
        query.descend("pages").constrain(Thesis.class);
        ObjectSet result = query.execute();
        listResult(result);
    }

    static void retrieveAllDissertationFromAM(ObjectContainer db) {

        System.out.println("\n------\nRetrieve all Dissertation from Academic monograph\n");

        Query query = db.query();
        query.constrain(AcademicMonograph.class);
        query.descend("pages").constrain(Dissertation.class);
        ObjectSet result = query.execute();
        listResult(result);
    }

    static void retrieveAllSerialItems(ObjectContainer db) {

        System.out.println("\n------\nRetrieve all Serial Items\n");

        Query query = db.query();
        query.constrain(SerialItem.class);
        query.descend("number").constrain(Item.class);
        ObjectSet result = query.execute();
        listResult(result);
    }

    static void retrieveAllItems(ObjectContainer db) {

        System.out.println("\n------\nRetrieve all Items\n");

        Query query = db.query();
        query.constrain(Item.class);
        query.descend("pages").orderAscending();
        ObjectSet result = query.execute();
        listResult(result);
    }

    // Accounts

    static void retrieveAllAccounts(ObjectContainer db) {

        System.out.println("\n------\nRetrieve all Accounts\n");

        Query query = db.query();
        query.constrain(Account.class);
        query.descend("valid");
        ObjectSet result = query.execute();
        listResult(result);
    }

    static void retrieveAllAccountsByNegation(ObjectContainer db) {

        System.out.println("\n------\nRetrieve all Accounts by negation\n");

        Query query = db.query();
        query.constrain(Account.class);
        query.descend("valid").constrain(true).not();
        ObjectSet result = query.execute();
        listResult(result);
    }

    static void updateCopiesBook1(ObjectContainer db) {

        System.out.println("\n------\nAdding copies to an item\n");

        List<Book> result = db.query(new Predicate<Book>() {
            public boolean match(Book book) {
                return book.getIBAN().equals("Book1");
            }
        });
        Book found = (Book) result.get(0);
        System.out.println("Before: " + found);

        List<Copy> copiesBook1 = found.getCopies();
        copiesBook1.add(new Copy("12", new Date(2020, Calendar.JUNE, 10), "Senhora da Hora", found, null));
        copiesBook1.add(new Copy("11", new Date(2020, Calendar.JUNE, 10), "Senhora da Hora", found, null));

        found.setCopies(copiesBook1);

        db.store(found);

        result = db.query(new Predicate<Book>() {
            public boolean match(Book book) {
                return book.getIBAN().equals("Book1");
            }
        });

        System.out.println("After");
        listResult(result);
    }

    static void updateAccountPerson3ToInvalid(ObjectContainer db) {

        System.out.println("\n------\nUpdate account to invalid\n");

        List<Person> result = db.query(new Predicate<Person>() {
            public boolean match(Person person) {
                return person.getName().equals("person3");
            }
        });

        Person found = (Person) result.get(0);
        System.out.println("Before: " + found);

        Account account = found.getAccount();
        account.setValid(false);

        found.setAccount(account);
        db.store(found);
        result = db.query(new Predicate<Person>() {
            public boolean match(Person person) {
                return person.getName().equals("person3");
            }
        });
        listResult(result);
    }

    static Subject getSubject(ObjectContainer db, final String name) {

        List<Subject> result = db.query(new Predicate<Subject>() {
            public boolean match(Subject subject) {
                return subject.getName().equals(name);
            }
        });

        return (Subject) result.get(0);
    }

    static void borrowItems(ObjectContainer db) {

        System.out.println("\n------\nBorrow Items\n");

        final Subject person = getSubject(db, "person1");
        List<Account> result = db.query(new Predicate<Account>() {
            public boolean match(Account account) {
                return account.getPerson().equals(person);
            }
        });

        Account accountFound = (Account) result.get(0);
        List<Borrow> borrows = accountFound.getBorrows();

        List<Book> bookResult = db.query(new Predicate<Book>() {
            public boolean match(Book book) {
                return book.getIBAN().equals("Book1");
            }
        });
        Book bookFound = (Book) bookResult.get(0);
        Copy copy = bookFound.getCopies().get(0);
        Borrow newBorrow = new Borrow(new Date(2021, Calendar.APRIL, 6), null, copy, accountFound);
        borrows.add(newBorrow);

        bookFound.getCopies().get(0).setBorrows(newBorrow);
        accountFound.setBorrows(borrows);

        System.out.println(accountFound.getBorrows().size());
        db.store(accountFound);
        db.store(bookFound);
    }

    static void clearDatabase(ObjectContainer db) {

        ArrayList<Class> clearDB = new ArrayList<Class>();
        clearDB.add(Subject.class);
        clearDB.add(Item.class);
        clearDB.add(Person.class);

        while (clearDB.iterator().hasNext()) {
            ObjectSet result = db.queryByExample(Person.class);
            while (result.hasNext()) {
                db.delete(result.next());
            }
        }

    }

    public static void retrieveByConjunction(ObjectContainer db) {
        Query query=db.query();
        query.constrain(Subject.class);
        Constraint constr=query.descend("name")
                .constrain("person1");
        query.descend("monographList")
                .constrain(null).and(constr);
        ObjectSet result=query.execute();
        listResult(result);
    }

    public static void retrieveByDisjunction(ObjectContainer db) {
        Query query=db.query();
        query.constrain(Subject.class);
        Constraint constr=query.descend("name")
                .constrain("person1");
        query.descend("monographList")
                .constrain( new ArrayList<Monograph>()).or(constr);
        ObjectSet result=query.execute();
        listResult(result);
    }

    public static void retrieveByComparison(ObjectContainer db) {
        Query query=db.query();
        query.constrain(Book.class);
        query.descend("copies")
                .constrain(9).greater();
        ObjectSet result=query.execute();
        listResult(result);
    }

    static void retrieveByDefaultFieldValue(ObjectContainer db) {
        Person somebody=new Person("Somebody else",new ArrayList<Monograph>());
        db.store(somebody);
        Query query=db.query();
        query.constrain(Person.class);
        query.descend("monographList").constrain(new ArrayList<Monograph>());
        ObjectSet result=query.execute();
        listResult(result);
        db.delete(somebody);
    }

    public static void retrieveSorted(ObjectContainer db) {
        Query query=db.query();
        query.constrain(Item.class);
        query.descend("pages").orderAscending();
        ObjectSet result=query.execute();
        listResult(result);
        query.descend("pages").orderDescending();
        result=query.execute();
        listResult(result);
    }
}