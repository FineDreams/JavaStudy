import java.util.List;

public class PageBean {
    private List<Book> books;
    private int pageCode;
    private int totalData;
    private int pageSize=10;

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    //多条件组合查询时的参数
    private String params;

    public int getPageSize() {
        return pageSize;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "books=" + books +
                ", pageCode=" + pageCode +
                '}';
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getTotalPages() {
        int ps=totalData/10;
        if (totalData % 10>0){
            return ps++;
        }
        return ps;
    }


    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public PageBean() {

    }

    public PageBean(List<Book> books , int pageCode) {

        this.books = books;
        this.pageCode = pageCode;
    }
}
