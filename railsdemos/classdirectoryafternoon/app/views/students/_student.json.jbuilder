json.extract! student, :id, :fullname, :phone, :classid, :created_at, :updated_at
json.url student_url(student, format: :json)