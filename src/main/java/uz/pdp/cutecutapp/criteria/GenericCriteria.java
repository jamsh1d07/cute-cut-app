package uz.pdp.cutecutapp.criteria;

import lombok.Setter;

import java.util.Objects;

@Setter
public class GenericCriteria implements BaseCriteria {
    private Integer size;
    private Integer page;


    public Integer getPage() {
        if (Objects.isNull(page))
            page = 0;
        return page;
    }

    public Integer getSize() {
        if (Objects.isNull(size))
            size = 10;
        return size;
    }
}
