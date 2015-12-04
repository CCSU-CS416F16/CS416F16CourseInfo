json.array!(@students) do |student|
  json.extract! student, :id, :fullname, :phone, :classid
  json.url student_url(student, format: :json)
end
