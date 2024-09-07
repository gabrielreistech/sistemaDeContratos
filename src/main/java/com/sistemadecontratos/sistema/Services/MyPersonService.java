package com.sistemadecontratos.sistema.Services;

import com.sistemadecontratos.sistema.Dtos.MyPersonDto;
import com.sistemadecontratos.sistema.Models.MyPerson;
import com.sistemadecontratos.sistema.Repositorys.MyPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MyPersonService {

    @Autowired
    MyPersonRepository myPersonRepository;

    @Autowired
    EmailService emailService;

    @Transactional
    public MyPersonDto create(MyPersonDto myPersonDto){
        MyPerson myPerson = new MyPerson(myPersonDto);
        myPerson = this.myPersonRepository.save(myPerson);
        emailService.sendSimpleEmail(
                myPerson.getEmail(),
                "Bem vindo ao Contracts System!",
                "Você agora tem um sistema completo de contratos etc...");
        return new MyPersonDto(myPerson);
    }

    @Transactional
    public List<MyPersonDto> findAll(){
        List<MyPerson> person = this.myPersonRepository.findAll();
        return person.stream().map(MyPersonDto::new).toList();
    }

    @Transactional
    public String deleteByName(String name){  /* Depois criar validação se realmente vai excluir porque se excluír aqui, zera todo o sistema*/
        Optional<MyPerson> findByName = this.myPersonRepository.findByName(name);
        if(findByName.isPresent()){
            this.myPersonRepository.delete(findByName.get());
            return "Excluído com sucesso";
        }else{
            findByName.orElseThrow(() -> new RuntimeException("Não localizado para exclusão."));
        }
        return name;
    }
}
