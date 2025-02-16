package pl.kurs.preTestHomework.library.model;

public enum Category {
    FANTASY, ROMANS, THILLER, DOKUMENT;

    public static Category fromString(String category)throws IllegalArgumentException{
        try{
            return Category.valueOf(category.toUpperCase());
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Niepoprawna kategoria. Wybierz z: FANTASY, ROMANS, THILLER, DOKUMENT");
        }
    }
}
