class Classroom < ApplicationRecord
  validates :teacher, :grade, :classid, :presence => true
validates :teacher, length: { minimum: 2 }
validates :grade, numericality: {greater_than: 0}

end
