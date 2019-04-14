package me.kagami.jpa.studyjpa;

import me.kagami.jpa.studyjpa.bean.Author;
import me.kagami.jpa.studyjpa.repository.AuthorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudyJpaApplicationTests {
 	@Autowired
	private AuthorRepository authorRepository;

 	@Test
	public void findOne() {
		Author author = new Author();
		author.setName("zhao");
		Example<Author> example = Example.of(author);
		System.out.println(authorRepository.findOne(example));
	}

	@Test
	public void findAll() {
		System.out.println(authorRepository.findAll());
	}


	@Test
	public void save() {
		Author author = new Author();
		author.setName("zhao");
		author.setAge(10);
		authorRepository.save(author);
		System.out.println(authorRepository.findAll());
	}
}
