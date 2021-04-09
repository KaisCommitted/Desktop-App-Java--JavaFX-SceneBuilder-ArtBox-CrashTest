<?php

namespace App\Controller;

use App\Entity\Interactions;
use App\Form\InteractionsType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/interactions")
 */
class InteractionsController extends AbstractController
{
    /**
     * @Route("/", name="interactions_index", methods={"GET"})
     */
    public function index(): Response
    {
        $interactions = $this->getDoctrine()
            ->getRepository(Interactions::class)
            ->findAll();

        return $this->render('interactions/index.html.twig', [
            'interactions' => $interactions,
        ]);
    }

    /**
     * @Route("/new", name="interactions_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $interaction = new Interactions();
        $form = $this->createForm(InteractionsType::class, $interaction);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($interaction);
            $entityManager->flush();

            return $this->redirectToRoute('interactions_index');
        }

        return $this->render('interactions/new.html.twig', [
            'interaction' => $interaction,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idInter}", name="interactions_show", methods={"GET"})
     */
    public function show(Interactions $interaction): Response
    {
        return $this->render('interactions/show.html.twig', [
            'interaction' => $interaction,
        ]);
    }

    /**
     * @Route("/{idInter}/edit", name="interactions_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Interactions $interaction): Response
    {
        $form = $this->createForm(InteractionsType::class, $interaction);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('interactions_index');
        }

        return $this->render('interactions/edit.html.twig', [
            'interaction' => $interaction,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idInter}", name="interactions_delete", methods={"POST"})
     */
    public function delete(Request $request, Interactions $interaction): Response
    {
        if ($this->isCsrfTokenValid('delete'.$interaction->getIdInter(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($interaction);
            $entityManager->flush();
        }

        return $this->redirectToRoute('interactions_index');
    }
}
