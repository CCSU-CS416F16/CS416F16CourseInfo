class CreateStudents < ActiveRecord::Migration
  def change
    create_table :students do |t|
      t.string :fullname
      t.string :phone
      t.string :classid

      t.timestamps null: false
    end
  end
end
