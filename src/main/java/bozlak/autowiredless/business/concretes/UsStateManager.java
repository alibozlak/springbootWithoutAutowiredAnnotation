package bozlak.autowiredless.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import bozlak.autowiredless.business.abstracts.UsStateService;
import bozlak.autowiredless.dataAccess.abstracts.UsStateDal;
import bozlak.autowiredless.entities.UsState;

@Service
public class UsStateManager implements UsStateService {

    private UsStateDal usStateDal;

    public UsStateManager(UsStateDal usStateDal) {
        this.usStateDal = usStateDal;
    }

    @Override
    public List<UsState> getAll() {
        return usStateDal.getAll();
    }

    @Override
    public UsState getById(int stateId) {
        return usStateDal.getById(stateId);
    }

    @Override
    public void add(UsState usState) {
        usStateDal.add(usState);
    }

    @Override
    public void update(UsState usState) {
        usStateDal.update(usState);
    }

    @Override
    public void delete(UsState usState) {
        usStateDal.delete(usState);
    }

}
