package com.codingdojo.main.savetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ninjas")
public class Ninja {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	  	@NotNull
	    @Size(min = 3, max = 50, message="Field must  be al least 3 characters.")
	    private String firstName;
	    @NotNull
	    @Size(min = 3, max = 50, message="Field must  be al least 3 characters.")
	    private String lastName;
	    @Min(value=12, message="Age must be more than 11." )
	    private int age;
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="dojo_id")
	    private Dojo dojo;
	    
	    public Ninja() {
	        
	    }
	    

		public Ninja( String firstName, String lastName, int age, Dojo dojo) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.dojo = dojo;
		}


		public Long getId() {
			return id;
		}



		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Dojo getDojo() {
			return dojo;
		}

		public void setDojo(Dojo dojo) {
			this.dojo = dojo;
		}
		
		@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
		@PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	
	    
	    

}
