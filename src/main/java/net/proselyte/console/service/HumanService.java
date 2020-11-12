package net.proselyte.console.service;

import net.proselyte.console.model.Human;


/**
 * GET возвращает пользователя по id
 * POST создает нового пользователя
 * PUT изменяет уже существующего пользователя
 * DELETE удаляет пользователя
 */
public interface HumanService {
    Human getBuId(Long id);
    void post(Human human);
    void put(Long id, Human human);
    void delete(Long id);



}
