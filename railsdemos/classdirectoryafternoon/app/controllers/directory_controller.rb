class DirectoryController < ApplicationController
  def search
  end

  def results
    @partial_name = "%" + params[:partial_name] + "%"
@students = Student.where("fullname like ?",
      @partial_name)

  end
end
