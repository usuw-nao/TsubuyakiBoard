package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Mutter;

public class MutterDaoImpl implements MutterDao {
	private DataSource ds;

	public MutterDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Mutter> findAll() throws Exception {
		List<Mutter> mutterList = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			String sql = "select id,name,text from MUTTER order by id DESC";
			PreparedStatement pStmt = con.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				Integer id = (Integer) rs.getInt("ID");
				String userName = rs.getString("name");
				String text = rs.getString("text");
				Mutter mutter = new Mutter(id, userName, text);
				mutterList.add(mutter);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return mutterList;
	}

	@Override
	public Mutter findById(int id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Mutter mutter) throws Exception {

	}

	@Override
	public void updated(Mutter mutter) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Mutter mutter) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public boolean create(Mutter mutter) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "insert into MUTTER(name,text)values(?,?)";
			PreparedStatement pStmt = con.prepareStatement(sql);

			pStmt.setString(1, mutter.getUserName());
			pStmt.setString(2, mutter.getText());

			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

}