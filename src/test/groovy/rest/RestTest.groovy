package rest

import org.testng.Assert
import org.testng.annotations.Test
import groovyx.net.http.*
import static groovyx.net.http.ContentType.*

class RestTest {

	@Test	
	def test1() {
		def client = new RESTClient('http://www.leveluplunch.com')
		def resp = client.get ( 
						path: '/groovy/examples/',
					)
		Assert.assertEquals(resp.status, 200)
	}
	
	@Test
	def test2() {
		def client = new RESTClient('http://it-ebooks-api.info/v1/')
		def resp = client.get (
						path: 'search/jvm',
					)
		Assert.assertTrue(resp.status == 200 && resp.getData().Books[1].Description.contains('JRuby'))
	}

}
