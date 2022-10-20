package bozlak.autowiredless.dataAccess.abstracts;

import java.util.List;

import bozlak.autowiredless.entities.UsState;

public interface UsStateDal {
    List<UsState> getAll();
}
