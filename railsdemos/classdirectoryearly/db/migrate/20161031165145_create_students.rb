class CreateStudents < ActiveRecord::Migration[5.0]
  def change
    create_table :students do |t|
      t.string :fullname
      t.string :phone
      t.string :classid

      t.timestamps
    end
  end
end
