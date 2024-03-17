package high_performance.persistence.demo;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	@OneToMany(mappedBy = "post", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<PostComment> comments = new ArrayList<PostComment>();
	
	public void addComment(PostComment comment) {
		comments.add(comment);
		comment.setPost(this);
	}
	
	public void removeComment(PostComment comment) {

		comments.remove(comment);
		comment.setPost(null);
	}

	public Post(String title) {
		super();
		this.title = title;
	}
	

}
