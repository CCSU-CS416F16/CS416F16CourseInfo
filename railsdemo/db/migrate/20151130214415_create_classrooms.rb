class CreateClassrooms < ActiveRecord::Migration
  def change
    create_table :classrooms do |t|
      t.string :teacher
      t.integer :grade
      t.string :classid

      t.timestamps null: false
    end
  end
end
