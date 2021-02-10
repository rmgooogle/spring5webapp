package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepo;
import guru.springframework.spring5webapp.repositories.BookRepo;
import guru.springframework.spring5webapp.repositories.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo publisherRepo;

    public BootStrapData(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {


        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book ("Domain Driven Design", "123123");
        Publisher publisher = new Publisher();
        publisher.setAddress("Tomsk");
        publisher.setName("DovzhenkoIS");
        publisher.setState("without State");
        publisher.setZip("notNull");

        publisherRepo.save(publisher);


        System.out.println("That Publisher " + publisher.toString());
        System.out.println(" All publ= " + publisherRepo.count());

        Publisher publisherNew = new Publisher();
        publisherNew.setAddress("Tomsk");
        publisherNew.setName("Bazhenov");
        publisherNew.setState(" Colorado");
        publisherNew.setZip("notNull");

        publisherRepo.save(publisherNew);
        System.out.println("That Publisher " + publisherNew.toString());
        System.out.println(" All publ= " + publisherRepo.count());

        Publisher publisherPop = new Publisher();
        publisherNew.setAddress("Tayga");
        publisherNew.setName("Popenkov");
        publisherNew.setState("Siberian");
        publisherNew.setZip("notNull");

        publisherRepo.save(publisherPop);
        System.out.println("That Publisher " + publisherPop.toString());
        System.out.println(" All publ= " + publisherRepo.count());



        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepo.save(eric);
        bookRepo.save(ddd);
        publisherRepo.save(publisher);



        Author rod = new Author("Rod", "Jons");
        Book noEJBS = new Book("J2EE Dev without EJB", "222332");
        rod.getBooks().add(noEJBS);
        noEJBS.getAuthors().add(rod);

        noEJBS.setPublisher(publisher);
        publisher.getBooks().add(noEJBS);
        authorRepo.save(rod);
        bookRepo.save(noEJBS);
        publisherRepo.save(publisher);


        System.out.println("Starting");
        System.out.println("Numb " + bookRepo.count());
        System.out.println(" Publisher count " + publisherRepo.count());
        System.out.println("Publisher: numb of book " + publisher.getBooks().size());

    }
}
