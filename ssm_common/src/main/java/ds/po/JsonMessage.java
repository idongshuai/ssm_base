package ds.po;

/**
 * 用于前后端json数据交互
 *
 * @author 董帅
 */
public class JsonMessage {
    //后端向前端响应成功或失败等消息
    private String msg;

    //前端向后端发送json格式的数据, 用于批量删除
    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
