package bozlak.autowiredless.business.abstracts;

import java.util.List;

import bozlak.autowiredless.entities.UsState;

public interface UsStateService {
    List<UsState> getAll();
    UsState getById(int stateId);
    void add(UsState usState);
    void update(UsState usState);
    void delete(UsState usState);
}
