Rails.application.routes.draw do
  get 'directory/search'

  get 'directory/results'

  resources :students
  resources :classrooms
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
