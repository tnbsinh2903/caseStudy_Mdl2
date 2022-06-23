package comic_rental_shop_manager.tnbs.services;

import comic_rental_shop_manager.tnbs.model.Manga;

import java.util.List;

public interface IMangaService {
    List<Manga> findAll();
       void add(Manga newManga);
       void update(Manga newManga);
      Manga findById(long id);
      boolean existById(long id);
      boolean existByName(String name);
      boolean exist(int id);
      void removeById(int id);
      List<Manga> sortPriceMangaASC();
      List<Manga> sortPriceMangaDESC();

}
