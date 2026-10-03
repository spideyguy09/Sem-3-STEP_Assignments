package week8.practice_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract LocalDate getDueDate(LocalDate currentDate);
    public String getTitle() { return title; }
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    @Override
    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14);
    }
}

class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }

    @Override
    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7);
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    @Override
    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = Integer.parseInt(scanner.nextLine().trim());
        
        List<LibraryItem> items = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1).replace("\"", "");
            
            if (type.equals("BOOK")) {
                items.add(new Book(title));
            } else if (type.equals("DVD")) {
                items.add(new DVD(title));
            } else if (type.equals("MAGAZINE")) {
                items.add(new Magazine(title));
            }
        }
        
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.getDueDate(currentDate));
        }
    }
}
