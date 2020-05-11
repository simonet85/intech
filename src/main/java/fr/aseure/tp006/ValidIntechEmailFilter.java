package fr.aseure.tp006;

public class ValidIntechEmailFilter implements EmailFilter {
    @Override
    public boolean filter(String email) {
        return email.contains("intech");
    }
}
