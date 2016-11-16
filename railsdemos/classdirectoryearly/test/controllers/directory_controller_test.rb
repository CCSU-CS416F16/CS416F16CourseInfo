require 'test_helper'

class DirectoryControllerTest < ActionDispatch::IntegrationTest
  test "should get search" do
    get directory_search_url
    assert_response :success
  end

  test "should get results" do
    get directory_results_url
    assert_response :success
  end

end
