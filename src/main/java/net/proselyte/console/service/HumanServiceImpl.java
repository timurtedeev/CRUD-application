package net.proselyte.console.service;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import net.proselyte.console.model.Human;
import net.proselyte.console.repository.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Slf4j
@Service
public class HumanServiceImpl implements HumanService {
    @Autowired

    HumanRepository humanRepository;

    //GET возвращает пользователя по id
    @Override
    public Human getBuId(Long id) {
        log.info("IN HumanServiceImpl getBuId ", id);
        return humanRepository.getOne(id);
    }

    //POST создает нового пользователя
    @Override
    public void post(Human human) {
        log.info("IN HumanServiceImpl post {} ", human);
        humanRepository.save(human);
    }

    //PUT изменяет уже существующего пользователя
    @Override
    public void put(Long id, Human human) {
        log.info("IN HumanServiceImpl put {} ", id,human);
        if (humanRepository.existsById(id)) {
            humanRepository.save(human);
        }
    }

    //DELETE удаляет пользователя
    @Override
    public void delete(Long id) {
        log.info("IN HumanServiceImpl delete {} ", id);
        if(humanRepository.existsById(id))
            humanRepository.deleteById(id);
    }
}
