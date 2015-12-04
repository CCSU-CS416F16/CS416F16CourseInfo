class Student < ActiveRecord::Base
  validates :phone, length:{in: 7..10,
                            message:"Your phone number must have 7-10 digits" }

end
