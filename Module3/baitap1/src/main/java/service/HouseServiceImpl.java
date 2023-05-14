package service;

import entities.House;
import entities.HouseDao;
import repos.HouseRepoImpl;
import repos.IRepo;
import repos.PersonRepo;

import java.util.List;

public class HouseServiceImpl implements IService<HouseDao> {

    private IRepo<HouseDao> houseRepo = new HouseRepoImpl();
    private PersonRepo personRepo = new PersonRepo();

    @Override
    public List<HouseDao> findAll(String searchName, String index) {
        return houseRepo.findAll(searchName, index);
    }

    @Override
    public HouseDao findById(String id) {
        return houseRepo.findById(id);
    }

    @Override
    public void save(HouseDao houseDao) {
        HouseDao oldHouseData = findById(houseDao.getId());
        personRepo.update(oldHouseData.getHhName(), houseDao.getHhName());
        houseRepo.update(houseDao);
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public int pages() {
        double items = houseRepo.countItem();
        return (int) Math.ceil(items / 5);    }
}
