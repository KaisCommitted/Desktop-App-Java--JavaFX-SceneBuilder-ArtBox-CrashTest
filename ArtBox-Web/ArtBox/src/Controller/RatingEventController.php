<?php

namespace App\Controller;

use App\Entity\RatingEvent;
use App\Form\RatingEventType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/rating/event")
 */
class RatingEventController extends AbstractController
{
    /**
     * @Route("/", name="rating_event_index", methods={"GET"})
     */
    public function index(): Response
    {
        $ratingEvents = $this->getDoctrine()
            ->getRepository(RatingEvent::class)
            ->findAll();

        return $this->render('rating_event/index.html.twig', [
            'rating_events' => $ratingEvents,
        ]);
    }

    /**
     * @Route("/new", name="rating_event_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $ratingEvent = new RatingEvent();
        $form = $this->createForm(RatingEventType::class, $ratingEvent);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($ratingEvent);
            $entityManager->flush();

            return $this->redirectToRoute('rating_event_index');
        }

        return $this->render('rating_event/new.html.twig', [
            'rating_event' => $ratingEvent,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idRating}", name="rating_event_show", methods={"GET"})
     */
    public function show(RatingEvent $ratingEvent): Response
    {
        return $this->render('rating_event/show.html.twig', [
            'rating_event' => $ratingEvent,
        ]);
    }

    /**
     * @Route("/{idRating}/edit", name="rating_event_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, RatingEvent $ratingEvent): Response
    {
        $form = $this->createForm(RatingEventType::class, $ratingEvent);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('rating_event_index');
        }

        return $this->render('rating_event/edit.html.twig', [
            'rating_event' => $ratingEvent,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idRating}", name="rating_event_delete", methods={"POST"})
     */
    public function delete(Request $request, RatingEvent $ratingEvent): Response
    {
        if ($this->isCsrfTokenValid('delete'.$ratingEvent->getIdRating(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($ratingEvent);
            $entityManager->flush();
        }

        return $this->redirectToRoute('rating_event_index');
    }
}
