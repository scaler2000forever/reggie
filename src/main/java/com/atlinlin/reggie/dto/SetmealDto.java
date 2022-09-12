package com.atlinlin.reggie.dto;

import com.atlinlin.reggie.entity.Setmeal;
import com.atlinlin.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
