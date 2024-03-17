package high_performance.persistence.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class Runner implements CommandLineRunner{

	@Autowired
	private EntityManager entityManager1;
	
	@Override
	public void run(String... args) throws Exception {
		
		// Unidirectional @ManyToOne
//		Post post = entityManager.find(Post.class, 1L);
//		PostComment comment = new PostComment("My review");
//		comment.setPost(post);
//		entityManager.persist(comment);
//		comment.setReview("So good");
		
		// Bidirectional @OneToMany
		Post post = new Post("First post");
		entityManager1.persist(post);

		PostComment comment1 = new PostComment("My first review");
		post.addComment(comment1);
		PostComment comment2 = new PostComment("My second review");
		post.addComment(comment2);
		post.removeComment(comment2);
		entityManager1.persist(post);

	}
	
	
}
