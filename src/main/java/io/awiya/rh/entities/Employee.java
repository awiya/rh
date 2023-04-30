package io.awiya.rh.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
	@Column(length = 20)
    @NotEmpty(message = "Oops! Looks like you forgot to enter your first name. Please fill in this field to continue.")
    private String firstName;
	@Column(length = 20)
    @NotEmpty(message = "Oops! Looks like you forgot to enter your last name. Please fill in this field to continue.")
    private String lastName;
	@Column(length = 20)
    @Email(message = "Uh-oh! It seems like the email you entered isn't quite right. " +
            "Please make sure you've entered a valid email address, like 'example@email.com'. " +
            "Don't worry, we won't share your email with anyone." )
    @NotEmpty(message = "Oops! Looks like you forgot to enter your email." +
            " Please fill in this field to continue.")
    private String email;


}
