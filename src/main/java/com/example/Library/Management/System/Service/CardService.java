package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Entities.LibraryCard;
import com.example.Library.Management.System.Entities.Student;
import com.example.Library.Management.System.Enum.CardStatus;
import com.example.Library.Management.System.Repository.CardRepository;
import com.example.Library.Management.System.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    StudentRepository studentRepository;

    public LibraryCard generatePlainCard() {
        LibraryCard card = new LibraryCard();

        card.setCardStatus(CardStatus.New);

        card = cardRepository.save(card);

        return card;
    }

    public String associateWithStudent(Integer cardNo, Integer studentId) {

        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Student student = studentOptional.get();

        Optional<LibraryCard> libraryCardOptional = cardRepository.findById(cardNo);
        LibraryCard libraryCard = libraryCardOptional.get();

        libraryCard.setNameOnCard(student.getName());
        libraryCard.setCardStatus(CardStatus.Active);
        libraryCard.setStudent(student);

        student.setLibraryCard(libraryCard);
        studentRepository.save(student);

       return "Card with cardNo: " + cardNo + " has been assigned to student with studentId: " + studentId;
    }

}
