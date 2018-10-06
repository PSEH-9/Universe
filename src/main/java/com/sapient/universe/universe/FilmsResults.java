package com.sapient.universe.universe;
public class FilmsResults
{
    private String edited;

    private String[] starships;

    private String[] species;

    private String episode_id;

    private String opening_crawl;

    private String director;

    private String url;

    private String[] planets;

    private String title;

    private String created;

    private String producer;

    private String release_date;

    private String[] vehicles;

    private String[] characters;

    public String getEdited ()
    {
        return edited;
    }

    public void setEdited (String edited)
    {
        this.edited = edited;
    }

    public String[] getStarships ()
    {
        return starships;
    }

    public void setStarships (String[] starships)
    {
        this.starships = starships;
    }

    public String[] getSpecies ()
    {
        return species;
    }

    public void setSpecies (String[] species)
    {
        this.species = species;
    }

    public String getEpisode_id ()
    {
        return episode_id;
    }

    public void setEpisode_id (String episode_id)
    {
        this.episode_id = episode_id;
    }

    public String getOpening_crawl ()
    {
        return opening_crawl;
    }

    public void setOpening_crawl (String opening_crawl)
    {
        this.opening_crawl = opening_crawl;
    }

    public String getDirector ()
    {
        return director;
    }

    public void setDirector (String director)
    {
        this.director = director;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String[] getPlanets ()
    {
        return planets;
    }

    public void setPlanets (String[] planets)
    {
        this.planets = planets;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public String getProducer ()
    {
        return producer;
    }

    public void setProducer (String producer)
    {
        this.producer = producer;
    }

    public String getRelease_date ()
    {
        return release_date;
    }

    public void setRelease_date (String release_date)
    {
        this.release_date = release_date;
    }

    public String[] getVehicles ()
    {
        return vehicles;
    }

    public void setVehicles (String[] vehicles)
    {
        this.vehicles = vehicles;
    }

    public String[] getCharacters ()
    {
        return characters;
    }

    public void setCharacters (String[] characters)
    {
        this.characters = characters;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [edited = "+edited+", starships = "+starships+", species = "+species+", episode_id = "+episode_id+", opening_crawl = "+opening_crawl+", director = "+director+", url = "+url+", planets = "+planets+", title = "+title+", created = "+created+", producer = "+producer+", release_date = "+release_date+", vehicles = "+vehicles+", characters = "+characters+"]";
    }
}
			
			