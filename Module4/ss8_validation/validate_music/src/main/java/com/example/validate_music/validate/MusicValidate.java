package com.example.validate_music.validate;

import com.example.validate_music.model.Music;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class MusicValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Music)){
            return;
        }
        Music music = (Music) target;
        String name = music.getName();
        String singer=music.getSinger();
        String kind=music.getKind();
        String link=music.getLink();
        if (name.isEmpty()){
            errors.rejectValue("name","name.empty",null,"Tên không được để trống");
        }else if (name.length()>800){
            errors.rejectValue("name", "name.length",null," Độ dài quá 800 kí tự");
        }else if (name.matches("(^[~!@#$%^&*()_+/<>.,`:;'{}]+$)")){
            errors.rejectValue("name", "name.matches",null,"Tên không được chứa kí tự đặc biệt!");
        }
        if (singer.isEmpty()){
            errors.rejectValue("singer","singer.empty",null,"Ca sĩ không được để trống");
        }else if (singer.length()>300){
            errors.rejectValue("singer", "singer.length",null," Độ dài quá 800 kí tự");
        }else if (singer.matches("(^[~!@#$%^&*()_+/<>.,`:;'{}]+$)")){
            errors.rejectValue("singer", "singer.matches",null,"Ca sĩ không được chứa kí tự đặc biệt!");
        }
        if (kind.isEmpty()){
            errors.rejectValue("kind","kind.empty",null,"Thể loại không được để trống");
        }else if (kind.length()>1000){
            errors.rejectValue("kind", "kind.length",null," Độ dài quá 800 kí tự");
        }else if (kind.matches("(^[~!@#$%^&*()_+/<>.`:;'{}]+$)")){
            errors.rejectValue("kind", "kind.matches",null,"Thể loại không được chứa kí tự đặc biệt!");
        }
        ValidationUtils.rejectIfEmpty(errors,"link","link.empty",null,"Đường link không được để trống");
    }
}
