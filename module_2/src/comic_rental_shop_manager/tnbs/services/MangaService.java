package comic_rental_shop_manager.tnbs.services;

import comic_rental_shop_manager.tnbs.model.Manga;
import comic_rental_shop_manager.tnbs.utils.CsvUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MangaService implements IMangaService {

    public static ArrayList<Manga> mangas = new ArrayList<>();

    public MangaService() {
    }

    ;

    public final static String PATH = "data\\manga.csv";

    public List<Manga> findAll() {
        List<Manga> mangas = new ArrayList<>();
        List<String> record = CsvUtils.read(PATH);
        for (String records : record) {
            mangas.add(Manga.parse(records));
        }
        return mangas;
    }

    @Override
    public void add(Manga newManga) {
        List<Manga> mangas = findAll();
        newManga.setCreatedAt((Instant.now()));
        mangas.add(newManga);
        CsvUtils.write(PATH, mangas);
    }

    @Override
    public void update(Manga newManga) {
        List<Manga> mangas = findAll();
        for (Manga manga : mangas) {
            if (manga.getId() == newManga.getId()) {
                String title = newManga.getTitle();
                if (title != null && !title.isEmpty()) {
                    manga.setTitle(newManga.getTitle());
                }
                String category = newManga.getCategory();
                if (category != null && !category.isEmpty()) {
                    manga.setCategory(newManga.getCategory());
                }
                Double price = newManga.getPrice();
                if (price != null) {
                    manga.setPrice(price);
                }
                Integer quantity = newManga.getQuantity();
                if (quantity != null) {
                    manga.setQuantity(quantity);
                }
                manga.setUpdatedAt(Instant.now());
                CsvUtils.write(PATH, mangas);
                break;
            }
        }

    }

    @Override
    public Manga findById(long id) {
        List<Manga> mangas = findAll();
        for (Manga manga : mangas) {
            if (manga.getId() == id)
                return manga;
        }
        return null;
    }

    @Override
    public boolean existById(long id) {
        List<Manga> mangas = findAll();
        for (Manga manga : mangas) {
            if (manga.getId() == id)
                return true;
        }
        return false;
    }

    @Override
    public boolean existByName(String name) {
        List<Manga> mangas = findAll();
        for (Manga manga : mangas) {
            if (manga.getTitle().equals(name))
                return true;
        }
        return false;
    }


    @Override
    public boolean exist(int id) {
        return findById(id) != null;
    }

    @Override
    public void removeById(int id) {
        List<Manga> mangas = findAll();
        mangas.removeIf(new Predicate<Manga>() {
            @Override
            public boolean test(Manga manga) {
                return manga.getId() == id;
            }
        });
        CsvUtils.write(PATH, mangas);
    }

    @Override
    public List<Manga> sortPriceMangaASC() {
        List<Manga> mangas = new ArrayList<>(findAll());
        mangas.sort(new Comparator<Manga>() {
            @Override
            public int compare(Manga o1, Manga o2) {
                double result = o1.getPrice() - o2.getPrice();
                if (result == 0)
                    return 0;
                return result > 0 ? 1 : -1;
            }
        });
        return mangas;
    }

    @Override
    public List<Manga> sortPriceMangaDESC() {
        List<Manga> mangas = new ArrayList<>(findAll());
        mangas.sort(new Comparator<Manga>() {
            @Override
            public int compare(Manga o1, Manga o2) {
                double result = o2.getPrice() - o1.getPrice();
                if (result == 0)
                    return 0;
                return result > 0 ? 1 : -1;
            }
        });
        return mangas;
    }


}
