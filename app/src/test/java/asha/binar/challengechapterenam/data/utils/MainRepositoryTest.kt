package asha.binar.challengechapterenam.data.utils

import asha.binar.challengechapterenam.data.helper.ApiHelper
import asha.binar.challengechapterenam.data.network.ApiService
import asha.binar.challengechapterenam.data.room.Favorite
import asha.binar.challengechapterenam.data.room.FavoriteDao
import asha.binar.challengechapterenam.model.credit.GetCreditResponse
import asha.binar.challengechapterenam.model.detailmovie.GetDetailMovieResponse
import asha.binar.challengechapterenam.model.nowplaying.GetNowPlayingResponse
import asha.binar.challengechapterenam.model.popularmovie.GetPopularMovieResponse
import asha.binar.challengechapterenam.model.users.GetUserResponse
import asha.binar.challengechapterenam.model.users.GetUserResponseItem
import asha.binar.challengechapterenam.model.users.PostUserResponse
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class MainRepositoryTest{
    private lateinit var service : ApiService
    private lateinit var apiHelper: ApiHelper
    private lateinit var repository: MainRepository
    private lateinit var favoriteDao: FavoriteDao

    private val detail = 634649
    private val fav = Favorite(1, "b", detail, "d")
    private val email = "asha@gmail.com"
    private val user = PostUserResponse("a", "b", "c", "d", "e", "f")

    @Before
    fun setUp(){
        service = mockk()
        favoriteDao = mock(FavoriteDao::class.java)
        apiHelper = ApiHelper(service, service)
        repository = MainRepository(apiHelper, favoriteDao)
    }

    @Test
    fun getPopularMovie() : Unit = runBlocking {
        val response = mockk<GetPopularMovieResponse>()
        every {
            runBlocking {
                service.getPopularMovie(API_KEY)
            }
        } returns response

        repository.getPopularMovie(API_KEY)

        verify {
            runBlocking {
                service.getPopularMovie(API_KEY)
            }
        }
    }

    @Test
    fun getNowPlayingMovie(): Unit = runBlocking {
        val response = mockk<GetNowPlayingResponse>()

        every {
            runBlocking {
                service.getNowPlayingMovie(API_KEY)
            }
        } returns response

        repository.getNowPlayingMovie(API_KEY)

        verify {
            runBlocking {
                service.getNowPlayingMovie(API_KEY)
            }
        }
    }

    @Test
    fun getDetailMovie() : Unit = runBlocking{
        val response = mockk<GetDetailMovieResponse>()

        every {
            runBlocking {
                service.getDetailMovie(detail, API_KEY)
            }
        } returns response

        repository.getDetailMovie(detail, API_KEY)

        verify {
            runBlocking {
                service.getDetailMovie(detail, API_KEY)
            }
        }
    }

    @Test
    fun getCreditMovie() : Unit = runBlocking{
        val response = mockk<GetCreditResponse>()

        every {
            runBlocking {
                service.getCreditMovie(detail, API_KEY)
            }
        } returns response

        repository.getCreditMovie(detail, API_KEY)

        verify {
            runBlocking {
                service.getCreditMovie(detail, API_KEY)
            }
        }
    }

    @Test
    fun getSimilarMovie() : Unit = runBlocking{
        val response = mockk<GetPopularMovieResponse>()

        every {
            runBlocking {
                service.getSimilarMovie(detail, API_KEY)
            }
        } returns response

        repository.getSimilarMovie(detail, API_KEY)

        verify {
            runBlocking {
                service.getSimilarMovie(detail, API_KEY)
            }
        }
    }

    @Test
    fun getUser() : Unit = runBlocking{
        val response = mockk<GetUserResponse>()

        every {
            runBlocking {
                service.getUser(email)
            }
        } returns response

        repository.getUser(email)

        verify {
            runBlocking {
                service.getUser(email)
            }
        }
    }

    @Test
    fun addUsers() : Unit = runBlocking{
        val response = mockk<GetUserResponseItem>()

        every {
            runBlocking {
                service.addUsers(user)
            }
        } returns response

        repository.addUsers(user)

        verify {
            runBlocking {
                service.addUsers(user)
            }
        }
    }

    @Test
    fun updateUser() : Unit = runBlocking{
        val response = mockk<GetUserResponseItem>()

        every {
            runBlocking {
                service.updateUser(user, "80")
            }
        } returns response

        repository.updateUser(user, "80")

        verify {
            runBlocking {
                service.updateUser(user, "80")
            }
        }
    }

    @Test
    fun addFavorite() {
        favoriteDao.addFavorite(fav)
    }

    @Test
    fun deleteFavorite() {
        favoriteDao.deleteFavorite(fav)
    }

    @Test
    fun getFavorite() {
        favoriteDao.getFavorite(email)
    }

    companion object {
        private const val API_KEY = "63be5170b074455a7fba3a528aeea4ce"
    }
}