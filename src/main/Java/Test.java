import Util.MyBaitsUtil;
import entity.Order;
import org.apache.ibatis.session.SqlSession;
/*
* 演示当实体类中的属性名和表中的字段名不一致时，使用MyBatis进行查询操作时无法查询出相应的结果的问题以及针对问题采用的两种办法：
　解决办法一: 通过在查询的sql语句中定义字段名的别名，让字段名的别名和实体类的属性名一致，这样就可以表的字段名和实体类的属性名一一对应上了，这种方式是通过在sql语句中定义别名来解决字段名和属性名的映射关系的。
  解决办法二: 通过<resultMap>来映射字段名和实体类属性名的一一对应关系。这种方式是使用MyBatis提供的解决方式来解决字段名和属性名的映射关系的。
* */
public class Test {
    public static void main(String[] args) {
        getOrderById();
        getOrderByAlias();
        getOrderByResultMap();
    }

    private static void getOrderById() {
        /**
         * * 映射sql的标识字符串，
         * mapper.orderMapper.getOrderById是orderMapper.xml文件中mapper标签的namespace属性的值，
         * getOrderById是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        SqlSession session=MyBaitsUtil.getSqlSession();
        String statement="mapper.orderMapper.getOrderById";
        Order order=session.selectOne(statement,1);
        session.close();
        System.out.println(order);
    }

    private static void getOrderByAlias() {
        /**
         * * 映射sql的标识字符串，
         * mapper.orderMapper.getOrderById是orderMapper.xml文件中mapper标签的namespace属性的值，
         * getOrderByAlias是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        SqlSession session=MyBaitsUtil.getSqlSession();
        String statement="mapper.orderMapper.getOrderByAlias";
        Order order=session.selectOne(statement,1);
        session.close();
        System.out.println(order);
    }

    private static void getOrderByResultMap() {
        /**
         * * 映射sql的标识字符串，
         * mapper.orderMapper.getOrderById是orderMapper.xml文件中mapper标签的namespace属性的值，
         * getOrderByResultMap是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        SqlSession session=MyBaitsUtil.getSqlSession();
        String statement="mapper.orderMapper.getOrderByResultMap";
        Order order=session.selectOne(statement,1);
        session.close();
        System.out.println(order);
    }
}
