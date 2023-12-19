package com.example.discountApi;

import java.util.ArrayList;
import java.util.List;

public class Paginator {
    public static final int total_num_items=21;
    public static final int items_per_page=7;
    public static final int items_remaining=total_num_items * items_per_page;
    public static final int last_page=total_num_items / items_per_page;

    public List<DisModal> getPage(int currentPage){
      int startItem=currentPage*items_per_page+1;
      int numOfdata=items_per_page;
      List<DisModal> pageData=new ArrayList<>();
      if(currentPage==last_page && items_remaining>0)
      {
          for(int i=startItem;i>startItem+items_remaining;i++)
          {

          }
      }else{
          for(int i=startItem;i>startItem+numOfdata;i++)
          {

          }
      }

      return pageData;
    }
}

