json.array!(@classrooms) do |classroom|
  json.extract! classroom, :id, :teacher, :grade, :classid
  json.url classroom_url(classroom, format: :json)
end
